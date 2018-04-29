package top.imshan.wallpaper.os;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 执行命令
 * @author shansb
 * @date 2018-04-26
 */
public class BashExecutor {
    /**
     * 判断系统中是否存在该命令
     * @param command 命令
     * @return true为存在
     */
    public boolean satisfy(String command){
        String executable = command+" --help";
        return execute(executable);
    }


    /**
     * 安装需要的package
     * @param command 命令
     * @param pwd 密码
     * @return 执行成功
     */
    public boolean installPackage(String command,String pwd){
        return execute("echo \"" + pwd + "\" |sudo apt-get install " + command);
    }

    /**
     * 更换壁纸
     * @return 执行是否成功
     */
    public boolean changeWallpaper(){
        return execute("src/unplash.sh");
    }
//    public static void main(String[] args) {
//        String cmd = "/home/deep4win/Documents/test.sh";
//        cmd = "which loi || 'echo 123'";
//        cmd = "/home/deep4win/Pictures/unplash.sh";
//        Process ps = Runtime.getRuntime().exec(cmd);
//        ps.waitFor();
//
//        printResult(ps);
//    }

    /**
     * 打印错误信息
     * @param ps process
     * @throws IOException
     */
    private static void printResult(Process ps) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String result = sb.toString();
        print("cmd");
        print(result);
    }

    private static void print(String string) {
        System.out.println(string);
    }


    /**
     * 执行命令
     * @param executable 可执行的命令字符串
     * @return 是否执行成功
     */
    public static boolean execute(String executable) {
        Process ps;
        try {
            ps = Runtime.getRuntime().exec(executable);
            ps.waitFor();
            printResult(ps);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return ps.exitValue() == 0;
    }
}
