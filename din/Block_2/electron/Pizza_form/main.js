// THE usual one we use:
const { app, BrowserWindow } = require('electron')
function createWindow() {
    let mainWindow = new BrowserWindow({
        width: 1000,
        height:700,
        webPreferences: {
            nodeIntegration: true
        }
    })
    // remove default chromium menu
    mainWindow.setMenu(null);
    mainWindow.loadFile('index.html')
    // Open the DevTools.
    // mainWindow.webContents.openDevTools ()
}
app.whenReady().then(createWindow);