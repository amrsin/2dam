
console.log('from index.js');

const path = require('path');
const url = require('url');

const BrowserWindow = require('electron').remote.BrowserWindow;
let winnew = new BrowserWindow({
    webPreferences: {
        nodeIntegration: true,
        enableRemoteModule: true
    },
});
winnew.loadURL(url.format({
    pathname: path.join(__dirname, 'secound_window.html'),
    protocol: 'file',
    slashes: true
}));

const bnt_window = document.getElementById('btn_win');
bnt_window.addEventListener('click', function (event) {

    let win_three = new BrowserWindow({

        webPreferences: {
            nativeWindowOpen: true,
            nodeIntegration: true
        }
    }); 
    win_three.loadURL(url.format({
        pathname: path.join(__dirname, 'third_window.html'),
        protocol: 'file',
        slashes: true
    }));
  }
)