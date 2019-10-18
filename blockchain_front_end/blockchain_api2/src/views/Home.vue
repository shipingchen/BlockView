<template>
  <div class="home">
    <!--  Rotation Diagram  -->
    <el-carousel trigger="click" style="width:99%" height="50vw">
      <el-carousel-item v-for="(item, index) in swiper" :key="index">
        <el-image :src="item" style="width:100%;height: 100%;"></el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
var swiper = [
  require("@/assets/images/banner1.png"),
  require("@/assets/images/banner2.jpeg"),
  require("@/assets/images/banner3.jpeg"),
  require("@/assets/images/banner4.png")
];
// @ is an alias to /src
export default {
  name: "home",
  components: {},
  data() {
    return {
      swiper: swiper
    };
  }
};
</script>

<style lang="scss">
.home {
  display: flex;
  justify-content: center;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
