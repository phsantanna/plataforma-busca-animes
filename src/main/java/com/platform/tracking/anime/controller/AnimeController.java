package com.platform.tracking.anime.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.platform.tracking.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @PostMapping
    public String getAnimeById(@RequestParam("animeId") String animeId, Model model) {
        JsonNode animeData = animeService.getAnimeDataById(animeId);

        if (animeData.has("data") && animeData.get("data").isArray() && !animeData.get("data").isEmpty()) {
            JsonNode animeAttributes = animeData.get("data").get(0).get("attributes");

            model.addAttribute("animeSlug", animeAttributes.get("slug").asText());
            model.addAttribute("animeSynopsis", animeAttributes.get("synopsis").asText());
            model.addAttribute("animePosterImage", animeAttributes.get("posterImage").asText());
            model.addAttribute("popularityRank", animeAttributes.get("popularityRank").asText());
            System.out.println();
            System.out.println("Slug: " + animeAttributes.get("slug").asText());
            System.out.println("Popularity Rank: "+animeAttributes.get("popularityRank").asText());
            System.out.println("Synopsis: " + animeAttributes.get("synopsis").asText());
            System.out.println("Post Image: "+animeAttributes.get("posterImage").asText());
            System.out.println();

        } else {
            model.addAttribute("error", "Anime not found");
        }
        model.addAttribute("animeId", animeId);
        return "index";
    }
    @ModelAttribute("posterImageSmall")
    public String getPosterImageLarge(@ModelAttribute("animeId") String animeId, Model model) {
        JsonNode animeData = animeService.getAnimeDataById(animeId);
        if (animeData.has("data") && animeData.get("data").isArray() && !animeData.get("data").isEmpty()) {
            JsonNode animeAttributes = animeData.get("data").get(0).get("attributes");
            return animeAttributes.get("posterImage").get("small").asText();
        }
        return "https://media.kitsu.io/anime/poster_images/1/small.jpg";
    }
}

