import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("./views/Home.vue")
    },
    {
      path: "/etheric/block",
      name: "etheric_block",
      component: () => import("./views/etheric/Block.vue")
    },
    {
      path: "/etheric/trade",
      name: "etheric_trade",
      component: () => import("./views/etheric/Trade.vue")
    },
    {
      path: "/etheric/animate",
      name: "etheric_animate",
      component: () => import("./views/etheric/Animate.vue")
    },
    {
      path: "/btc/block",
      name: "eos_block",
      component: () => import("./views/btc/Block.vue")
    },
    {
      path: "/btc/trade",
      name: "eos_trade",
      component: () => import("./views/btc/Trade.vue")
    },
    {
      path: "/btc/animate",
      name: "eos_animate",
      component: () => import("./views/btc/Animate.vue")
    },
    {
      path: "/search_result/:search_content",
      name: "search_result",
      component: () => import("./views/SearchResult.vue")
    }
  ]
});
