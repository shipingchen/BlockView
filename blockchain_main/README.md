# blockchain
firstly, install IntelliJ IDEA software.<br>

use  IDEA import this project.<br>

It is a blockchain visualization project, which is used to display the data of bitcoin and ethereum in real time through public API.<br>
This is a microservices architecture project, which consists of three independent projects.<br>
Firstly, you should run the eureka_server prject.<br>
Secondly, run the api-gateway project.<br>
Finally, run the this project.<br>

This whole project needs to set up a database. If you want to deploy it on your computer, you need to change the configuration parameter in yml file and the two test method to connect your database. If you do not set up a database, it cannot start up successfully.

Before visiting the website, we also need to run the testing code of two testing file to achieve real time uopdate, which are in the "product_service project"("BitcoinTest" and "EthereumTest") of blockchain_main package.<br>

when you finish above steps, the updating block information will display in the console.
