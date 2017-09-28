## Slack 機器人 環境設定
### 架構示意圖
![frame](https://i.imgur.com/kBdY2A8.png)
### 各個角色說明
- **adapter**:可以使hubot運行在不同的通訊平台<br>
- **hubot**  :機器人(生活小助手) ，負責接受訊息(指令)，和回應(問候，需求)<br>
- **通訊軟體**:fb line skype slack(我採用的)<br>
- **script** :coffeescript javascript ，可寫各種不同的功能(之後要好好學習的，目前是參考自網路現有資源)<br>
### IS "載東載西" TIME
1. node.js and npm _先載完這個再用npm載hubot_ > [install node.js](https://docs.npmjs.com/getting-started/installing-node)
2. hubot > [hubot document](https://hubot.github.com/docs/)
3. slack 帳號 (比較沒那麼普及的通訊app) but 經google後發現他主要是為了團隊溝通 在國外很火紅 <br>
3.1  _為了測試tatami是否正常運行_ > [slack相關](http://www.playpcesor.com/2015/06/slack.html)<br>
4. slack app <br>
4.1 build 一個出來<br>![tatami](https://i.imgur.com/L7tiQER.png)<br>

### imp. > cmd (命令提示字元部分)
- set HUBOT_SLACK_TOKEN= _api token_ 
- bin\hubot -a slack //啟用hubot的指令<br>
![成功部屬訊息](https://i.imgur.com/HjkAyNM.jpg)
### 其他 set
- **youtube相關** > set HUBOT_YOUTUBE_API_KEY= _api key_ >> [youtube相關服務for開發員](https://developers.google.com/youtube/v3/getting-started)
- **天氣相關**    > set HUBOT_FORECAST_API_KEY= _api key_ >> [天氣服務申請處](https://darksky.net/dev/register)
### SHOW TIME 
1. *say hi* <br>
![say hi](https://i.imgur.com/ZJlEQ6C.png)
2. *what's the weather today?* <br>
![weather](https://i.imgur.com/j62zAdb.png)
3. *caculator* <br>
![calculator](https://i.imgur.com/qUHrvsj.png)
4. *ptt hot news*<br>
![ptt](https://i.imgur.com/URmNaKH.png)
5. *apple 即時新聞標題*<br>
![apple](https://i.imgur.com/SrQOAev.png)
6. *依關鍵字傳youtube影片*<br>
![youtube](https://i.imgur.com/kQ1vd14.png)
7. *movie 近期電影* //but 可能因為 開眼電影網站 有改版 // 目前沒有回應 // <br>
![mt](https://i.imgur.com/uxMhcza.png)

### 特別感謝 _Reference_  
>[scripts 程式碼 參考出處](https://github.com/twtrubiks/mybot/tree/master/scripts)

