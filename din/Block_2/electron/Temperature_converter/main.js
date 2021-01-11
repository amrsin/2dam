// THE usual one we use:
const { app, BrowserWindow } = require('electron')
function createWindow() {
    let mainWindow = new BrowserWindow({
        width: 480,
        height: 280,
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