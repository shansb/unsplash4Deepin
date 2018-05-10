# unsplash4Deepin
>  Deepin下的unsplash壁纸更换程序


![Logo](https://github.com/shansb/unsplash4Deepin/blob/master/unsplash4Deepin/src/resource/Taskbar.png?raw=true)


### 安装

1. 右击本目录空白处，选择`在终端打开`。
2. 执行 `chmod +x install.sh`。
3. 执行 `./install.sh`。
4. 期间会要求输入密码用来创建图标和自启动。
5. 执行完毕后可在启动器菜单里看到应用

### 使用

安装好之后需要手动启动，启动后会在系统托盘中出现小图标，在下载照片期间小图标会动态显示。![trayIcon](https://github.com/shansb/unsplash4Deepin/blob/master/unsplash4Deepin/src/resource/TrayIcon.gif?raw=true)

1. 刷新：推荐双击小图标刷新；也可以通过右击图标，点击`refresh`菜单进行刷新。
2. 设置：右击托盘图标，点击`setting`会打开配置文件。
   1. CycleTime：可以自定义刷新时间，单位为小时。
   2. 保存后需要重启应用生效。
3. 退出：右击托盘图标，点击`quit` 即可。

### 删除

1. 右击本目录空白处，选择`在终端打开`。
2. 执行 `chmod +x uninstall.sh`。
3. 执行 `./uninstall.sh`。
4. 期间会要求输入密码用来删除相关文件。

### 其他

1. 因为网络问题有时应用一直会处于下载状态，请重启应用解决。