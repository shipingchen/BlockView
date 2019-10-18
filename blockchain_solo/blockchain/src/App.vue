<template>
  <div id="app">
    <el-container>
      <el-header>
        <TopNav
          @bindLangChange="bindLangChange"
          :languageData="languageData"
          :langs="langs"
          :langIndex="langIndex"
        ></TopNav>
      </el-header>
      <el-main>
        <RouterView
          :languageData="languageData"
        ></RouterView>
      </el-main>
      <el-footer>{{ languageData.footer }}</el-footer>
    </el-container>
  </div>
</template>

<script>
import language from "@/assets/langs/langs";
import TopNav from "@/components/TopNav";

export default {
  name: "app",
  components: {
    TopNav
  },
  data() {
    return {
      languageData: {},
      langs: [
        {
          label: "English",
          value: "en"
        },
        {
          label: "中文",
          value: "zh_CN"
        },
        {
          label: "español",
          value: "es"
        }
      ],
      langIndex: 0
    };
  },
  mounted() {
    this.languageData = language["en"];
  },
  methods: {
    bindLangChange(index) {
      this.langIndex = index;
      this.languageData = language[this.langs[index].value];
    }
  }
};
</script>

<style>
.el-footer {
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
}
.el-main {
  padding: 0 !important;
}
</style>
