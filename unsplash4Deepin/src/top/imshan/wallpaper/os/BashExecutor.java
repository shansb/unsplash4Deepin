package top.imshan.wallpaper.os;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 执行命令
 * @author shansb
 * @date 2018-04-26
 */
public class BashExecutor {
    /**
     * 错误信息
     */
    private static final String ERROR_MSG = "excute bash error";

	/**
     * 打印信息
     * @param is InputStream
     * @throws IOException
     */
    private static String stream2String(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String result = sb.toString();
        return result;
    }

    /**
     * 执行命令
     * @param executable 可执行的命令字符串
     * @return 是否执行成功
     */
    public static boolean execute(String executable) {
        String result = executeWithResult(executable);
        return !ERROR_MSG.equals(result);
    }
    
    /**
     * 执行命令,返回命令结果
     * @param executable 可执行的命令字符串
     * @return 执行结果
     */
    public static String executeWithResult(String executable) {
        System.out.print("cmd:");
        System.out.println(executable);
        Process ps;
        try {
            ps = Runtime.getRuntime().exec(executable);
            ps.waitFor();
            if (ps.exitValue() == 1) {
                System.err.println(stream2String(ps.getErrorStream()));
				return ERROR_MSG;
			} else {
				return stream2String(ps.getInputStream());
			}

        } catch (IOException e) {
            e.printStackTrace();
            return ERROR_MSG;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return ERROR_MSG;
        }
    }
}
