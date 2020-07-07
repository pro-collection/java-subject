package yanle.mybatis.plus.demo.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.mysql.cj.util.StringUtils;

import java.util.Scanner;

public class CodeGenerator {
    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入： " + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNullOrEmpty(ipt)) return ipt;
        }
        throw new MybatisPlusException("请输入正确的" + tip + "!");
    }
}
