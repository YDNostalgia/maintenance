package com.gxa.utils;

import com.gxa.mapper.DocNoGenerationUtilMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocNoGenerationUtil{

    @Autowired
    private DocNoGenerationUtilMapper docNoGenerationUtilMapper;

    /**
     *
     * @param businessId  业务Id（1：receipt，2：picking，3：return，4：inventory）
     * @return
     */
    public Integer generateDocNo(Integer businessId) {
        //格式说明 221021xxx 当前年月日+编号（年份只取最后两位）
        //获取当前时间编码
        Date date = new Date();
        String oddNumberStr = new SimpleDateFormat("yyMMdd").format(date);

        Integer oddNumber = null;

        String oddNumberStr1 = oddNumberStr + "000";
        Integer min = Integer.valueOf(oddNumberStr1);
        Integer max = min + 1000;
        HashMap<String, Integer> limitValue = new HashMap<>();

        limitValue.put("min",min);
        limitValue.put("max",max);
        limitValue.put("businessId",businessId);

        Integer total = this.docNoGenerationUtilMapper.queryQuantity(limitValue);

        if (total < min){
            oddNumber = min + 1;
        }else {
            oddNumber = total + 1;
        }

        HashMap<String, Integer> addMap = new HashMap<>();
        addMap.put("businessId",businessId);
        addMap.put("oddNumber",oddNumber);
        docNoGenerationUtilMapper.addNo(addMap);

        return oddNumber;
    }
}
