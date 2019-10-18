module.exports = {
    outputDir: 'dist',   //build
    assetsDir: 'assets', //(js, css, img)
    lintOnSave: false, //eslint
    devServer: {
        open: true, //auto
        host: "localhost", 
        port: '8080',
        https: false,
        hotOnly: false, 
        proxy: {
            '/api': {
                target: 'http://localhost:8771', //API Server Address
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        },
    }
}