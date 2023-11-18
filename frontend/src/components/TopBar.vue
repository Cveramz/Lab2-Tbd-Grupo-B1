<script>
  export default{
    data(){
      return {
        username: null
      }
    },
    methods: {
      getLogin(){
        this.username = JSON.parse(localStorage.getItem("login"))
      }
    },
    mounted() {
      this.getLogin()
    }
  }
</script>

<template>
  <div class="topbar">
    <div style="display: flex; text-align: center; align-items: center"> 
      <img class="usachLogo" src="./media/logodgt.png"/>
      <div class="logoTitle">VOLUNTARIADO <br/> USACH</div>
    </div>
    <div style="display: flex; text-align: center; align-items: center; margin: 20px">
      <div style="margin-right: 10px;">{{ this.username }}</div>
      <div class="useImgContainer"> 
        <img src="./media/user.png" height="50px"/>
      </div>
    </div>
  </div>
  
</template>

<style>

.topbar {
  display: flex;
  text-align: center;
  align-items: center;
  justify-content: space-between;
  position: absolute;
  background-color: #ffffff;
  z-index: 1;
  height: 100px;
  min-height: 100px;
  width: 100vw;
}
.usachLogo{
  height: 90px;
  margin: 0px 20px 10px 20px;
}

.logoTitle {
  display: none;
}
.useImgContainer {
  background-color: #d5d5d5;
  height: 50px;
  width: 50px;
  border-radius: 100px;
  border: #d3d3d3 solid 2px;
}

@media (min-width: 420px){
  .logoTitle {
    display: block;
    font-size: 30px;
    text-align: left;
    line-height: 1;
    font-weight: 500 !important;
  }
}


</style>
