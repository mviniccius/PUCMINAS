const sqlite3 = require('sqlite3').verbose();
const path = require('path');

class Database{
    constructor(){
        this.dbPath = path.join(__dirname, 'tasks.db');
        this.db = null;
    }
}