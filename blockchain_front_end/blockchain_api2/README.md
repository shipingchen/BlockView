

# Block Eye (Frontend which requires Backend)

### Prerequisites
```
Before using the code, you may need to make sure you have Node.js, Vue.js for frontend. 
```

### Directories
```
The main project files are placed in "src" directory, other directories are configurations.
In src structure, there are several folders and files as follows:
--- assets - static configurations (Languages, Block Numbers, etc.)
--- components - project component (Menu Bar)
--- plugins - element.js
--- views - web pages (BTC, Ethereum, Animations, Search)
--- APP.vue - project entry
--- element-variables.scss - general styles
--- main.js - peoject main file
--- router.js - routing paths
```
```
Also, one important config file is:
--- vue.config.js - cross domain configuration
```

### Installations
```
1. Enter into the project via terminal.
2. Type "npm install" to install dependencies, once finished you can see a new folder "node modules"
```

### Deploy Develoment Environment
```
1. Type "npm run serve"
2. You can see the project where it will be run in the terminal.
```

### Run the Project
```
1. Enter into the project via terminal.
2. Type "npm run serve" to start the project.
3. Need to check the latest block number at offcial blockchain website(Ethereum and/or BTC).
4. Modify the starting block number for Ethereum and/or BTC at src/assets/data/data.js.
5. Save all the files.
6. Check again whether the current webpage is real-time updated or not.
```

### What you can see after the above all
```
1. The welcome page of the Block Eye visualisation platform.
2. The menu bar for BTC, Ethereum, Search and language localisation.
```

### Note:
Please pay attention to the backend address.
```
You may need to change the backend target address at vue.config.js.
You may still need to change the baseURL at src/assets/data/data.js.
```
