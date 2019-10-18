<template>
    <div class="ani">
        <div class="ani-block" v-for="(item,index) in block" :key="index">
            <div>{{item.id}}</div>
            <div>Miner：{{item.miner}}</div>
            <div class="linkline" v-if="index !== (block.length - 1)"></div>
        </div>
    </div>
</template>

<script>
    function randomNum(minNum,maxNum){
        switch(arguments.length){
            case 1:
                return parseInt(Math.random()*minNum+1,10);
                break;
            case 2:
                return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10);
                break;
            default:
                return 0;
                break;
        }
    }
    export default {
        name: "Animate",
        data(){
            return {
                block:[],
                startId: "8275064",
                addFactor: 0,
                minerList:["f2pool","Nanopool","Ethermine","Sparkpool"],
                timeout: null
            }
        },
        mounted(){
            this.createBlock();
        },
        methods: {
            
            createBlock(){
                let minerIndex = randomNum(0,this.minerList.length-1);
                let block = {
                    id: parseInt(this.startId) + parseInt(this.addFactor),
                    miner: this.minerList[minerIndex]
                }

                if(this.addFactor == 7){
                    this.block = [];
                    this.addFactor = 0;
                }else{
                    this.block.push(block);
                }
                let that = this,time = randomNum(1000,3000);
                this.timeout = setTimeout(()=>{
                    that.createBlock();
                },time);
                this.addFactor ++;
            },

        }

    }
</script>

<style scoped lang="scss">
    .ani{
        width: 100%;
        height: 60vh;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px;
    }
    .ani-block{
        width: 200px;
        height: 80px;
        background: #409eff;
        border-radius: 4px;
        color: #fff;
        padding: 10px;
        box-sizing: border-box;
        margin: 0 20px;
        position: relative;
        .linkline{
            position: absolute;
            top: 40px;
            right: -40px;
            width: 40px;
            height: 2px;
            background: #cccccc;
        }
    }

</style>