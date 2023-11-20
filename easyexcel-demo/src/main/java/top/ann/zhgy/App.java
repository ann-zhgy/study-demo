package top.ann.zhgy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import top.ann.zhgy.bean.ExcelBean;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        File excel = new File("/Volumes/文枢工作空间/下载/20231020-A11_A71物料信息-20231110-确认今年不在售卖的物料类别-终版(1).xlsx");
        try {
            FileInputStream fis = new FileInputStream(excel);
            List<ExcelBean> data = new ArrayList<>();
            EasyExcel.read(fis, ExcelBean.class, new ReadListener<ExcelBean>() {
                @Override
                public void invoke(ExcelBean excelBean, AnalysisContext analysisContext) {
                    try {
                        Integer.parseInt(excelBean.getId());
                        data.add(excelBean);
                    } catch (NumberFormatException e) {
                        System.out.println("无效行");
                    }
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                }
            }).sheet("透视").doRead();
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> materialIds = data.stream().map(ExcelBean::getMaterial_id).collect(Collectors.toList());
            List<Map<String, Object>> materialIdAndGoodsTypeList = data.stream().map(excelBean -> {
                Map<String, Object> map = new HashMap<>();
                map.put("material_id", excelBean.getMaterial_id());
                map.put("goodsType", excelBean.getGoodsType());
                return map;
            }).collect(Collectors.toList());
            Map<String, Object> map = new HashMap<>();
            map.put("materialIds", materialIds);
            map.put("materialIdAndGoodsTypeList", materialIdAndGoodsTypeList);
            map.put("originData", data);
            System.out.println(objectMapper.writeValueAsString(map));
        } catch (Exception e) {
            // ignore
        }
    }
}
