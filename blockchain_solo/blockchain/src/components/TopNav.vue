<template>
  <div class="nav">
    <!--  Logo Image -->
    <div class="nav-logo">
      <el-image :src="logoImg"></el-image>
    </div>

    <!--  Navigation BAR  -->
    <div class="nav-menu">
      <el-menu :default-active="$route.path" mode="horizontal" router>
        <el-menu-item index="/">{{ languageData.home }}</el-menu-item>
        <el-submenu index="1">
          <template slot="title">{{ languageData.etheric }}</template>
          <el-menu-item index="/etheric/block">{{
            languageData.etheric_block_info
          }}</el-menu-item>
          <!--          <el-menu-item index="/etheric/trade">{{-->
          <!--            languageData.etheric_trade_info-->
          <!--          }}</el-menu-item>-->
          <el-menu-item index="/etheric/animate">{{
            languageData.etheric_animate_info
          }}</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">{{ languageData.btc }}</template>
          <el-menu-item index="/btc/block">{{
            languageData.btc_block_info
          }}</el-menu-item>
          <!--          <el-menu-item index="/btc/trade">{{-->
          <!--            languageData.btc_trade_info-->
          <!--          }}</el-menu-item>-->
          <el-menu-item index="/btc/animate">{{
            languageData.btc_animate_info
          }}</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>

    <!--  Search Barrr  -->
    <div class="nav-search">
      <el-autocomplete
        type="number"
        size="small"
        v-model="searchContent"
        value="value"
        value-key="label"
        :placeholder="languageData.searchPlaceHolder"
        :fetch-suggestions="querySearchAsync"
      >
        <el-button
          slot="append"
          icon="el-icon-search"
          @click="search"
        ></el-button>
      </el-autocomplete>
    </div>

    <!--  Language Selection  -->
    <div class="nav-lang">
      <el-dropdown trigger="click">
        <span class="el-dropdown-link">
          {{ langs[langIndex].label
          }}<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item
            v-for="(item, index) in langs"
            :key="index"
            @click.native="bindLangChange(index)"
          >
            {{ item.label }}
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import data from "@/assets/data/data";
var logoImg = require("@/assets/images/logo.png");
export default {
  name: "TopNav",
  props: ["languageData", "langIndex", "langs"],
  data() {
    return {
      searchContent: "", 
      logoImg: logoImg,
      searchAutoComplete: []
    };
  },
  mounted() {
    let searchData = [{ height: data.ETHERIC_blockno }];
    for (let i in searchData) {
      searchData[i].value = searchData[i].height[0];
      searchData[i].label = searchData[i].height;
    }
    this.searchAutoComplete = searchData;
  },
  methods: {
    search() {
      this.$router.push("/search_result/" + this.searchContent);
    },
    bindLangChange(index) {
      this.$emit("bindLangChange", index);
    },
    querySearchAsync(queryString, cb) {
      var searchAutoComplete = this.searchAutoComplete;
      var results = queryString
        ? searchAutoComplete.filter(this.createStateFilter(queryString))
        : searchAutoComplete;
      cb(results);
    },
    createStateFilter(queryString) {
      return state => {
        return (
          state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0
        );
      };
    }
  }
};
</script>

<style scoped lang="scss">
.nav {
  width: 100%;
  background-color:#FFEBCD;
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: solid 1px #e6e6e6;

  .nav-logo {
    width: 10%;
    min-width: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
    .el-image {
      width: 60%;
    }
    img {
      width: 100%;
    }
  }

  .nav-menu {
    width: 60%;
    .el-menu.el-menu--horizontal {
      border: none;
      background-color:#FFEBCD;
    }
  }
  .nav-search {
    width: 20%;
  }
  .nav-lang {
    width: 5%;
    text-align: right;
  }
}
.el-dropdown-link {
  cursor: pointer;
  color: #000000//#409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>
