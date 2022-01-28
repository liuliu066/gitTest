//package com.example.demo.test;
//
///**
// * @author lwh
// * @date 2022/1/22 14:38
// */
//package com.cnhtc.hbm.service.impl.cadre;
//
//import com.cnhtc.hbm.domain.info.*;
//import com.cnhtc.hbm.mapper.cadre.PersonalInfoMapper;
//import com.cnhtc.hbm.mapper.cadre.ResumeMapper;
//import com.cnhtc.hbm.util.TimeChange;
//import com.cnhtc.hbm.util.md5Util;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.*;
//
//@Service
//@Slf4j
//public class LeadershipInfoServiceImpl {
//
//    @Autowired
//    PersonalInfoMapper mapper;
//    @Autowired
//    ResumeMapper resumeMapper;
//
//    EhrToken tokenValue;
//
//    //    @Value("${spring.profiles.active}")
////    private String runtimeEnv;
//    private String runtimeEnv="dev";
////    private String runtimeEnv="test";
//
//    private final String EHR_API_IP = "http://10.2.156.70:8003/EhrBaseInfo/";
//
//    //是否测试环境
//    private boolean isCeshi;
//    private String PHOTO_PATH;
//    private String UPLOAD_DIR;
//
//    String gh="";
//
//    public LeadershipInfoServiceImpl() {
//        this.tokenValue = new EhrToken();
//        log.info("当前的环境为：{}",runtimeEnv);
//
//        //测试环境的保存图片路径和正式环境路径不同，所以要判断当前环境
//        if(runtimeEnv.equals("dev")){
//            isCeshi = false;
//            PHOTO_PATH = "http://cadresinfo.sinotruk.com:8001/cadrephoto/";
//            UPLOAD_DIR = "/home/sinotruk/cadrephoto";
//        }else{
//            isCeshi = true;
////            PHOTO_PATH = "http://223.99.1.153:8890/photo/";测试改动
//            PHOTO_PATH = "http://cadresinfo.sinotruk.com:8001/cadrephoto/";
//            UPLOAD_DIR = "D:\\IOSServer\\images\\photo";
//        }
//
//    }
//
//    public LeadershipInfo postBaseInfo(String gh){
//        this.gh = gh;
//        refreshToken();
//
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(12000);
//        requestFactory.setReadTimeout(10000);
//        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        restTemplate.getMessageConverters().add(new MyMappingJackson2HttpMessageConverter());
//        String url = EHR_API_IP+"BaseInfoApi/GetPersonInfoByGH";
//        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//        request.add("dateTime",tokenValue.getDateTime());
//        request.add("appKey",tokenValue.getAppKey());
//        request.add("appSecret",tokenValue.getAppappSecret());
//        request.add("worknum",gh);
//        ResponseEntity<Map> result = null;
//        try {
//            result = restTemplate.postForEntity(url, request, Map.class);
//        }catch (ResourceAccessException e){
//            log.error("ResourceAccessException捕获，请求失败，无数据或超时，超时信息{}",e.getMessage());
//            return new LeadershipInfo();
//        }catch (Exception e){
//            log.error("Exception捕获，请求失败，异常信息:{},异常的Cause信息：{},异常StackTrace信息：{}" ,e.getMessage(),e.getCause(),e.getStackTrace());
//            return new LeadershipInfo();
//        }
//
//        if (result == null){
//            return new LeadershipInfo();
//        }
//
//        LeadershipInfo leadershipInfo = getInfoByMap(result.getBody());
//        //生成照片，并且添加到leadershipInfo内。
//        boolean isSuccess = postPhoto(gh);
//        if(isSuccess){
//            leadershipInfo.getBaseInfo().setPhoto(PHOTO_PATH+gh+".jpg");
//        }
//        return leadershipInfo;
//    }
//
//    /**
//     * 传入工号获取图片
//     * @param gh 工号
//     * @return true为保存图片成功，false为失败
//     */
//    public boolean postPhoto(String gh){
//        //返回值，判断文件夹下是否有图片
//        boolean tupian = false;
//        long imageLength = 0L;
//        byte[] body = new byte[0];
//        try {
//            //请求图片
//            refreshToken();
//            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//            requestFactory.setConnectTimeout(1500);
//            requestFactory.setReadTimeout(1000);
//            RestTemplate restTemplate = new RestTemplate(requestFactory);
//            String url = EHR_API_IP+"BaseInfoApi/GetUserPhoto";
//            MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
//            request.add("dateTime", tokenValue.getDateTime());
//            request.add("appKey", tokenValue.getAppKey());
//            request.add("appSecret", tokenValue.getAppappSecret());
//            request.add("gh", gh);
//            body = restTemplate.postForObject(url, request, byte[].class);
//
//            imageLength = body.length;
//        }catch (ResourceAccessException e){
//            System.out.println("请求失败");
//        }catch (Exception e){
//            System.out.println("ALL请求失败");
//        }
//        //存放图片
//        OutputStream os;
//        String uploadDir = UPLOAD_DIR;
//
//        String image;
//        //判断当前是否是测试环境，因为测试环境在windwos下，而正式环境在linux下，所有文件路径命名不同
//        if (isCeshi){
//            image = uploadDir+"\\"+gh+".jpg";
//        }else{
//            image = uploadDir+"/"+gh+".jpg";
//        }
//
//        log.info("预计存储照片的文件夹：{}，路径：{}",uploadDir,image);
//        File dir1 = new File(uploadDir);
//        File dir2 = new File(image);
//        long fileLength = 0L;
//        boolean mkdirs = true;
//
//        //判断uploadDir路径是否存在，不存在则创建，创建文件夹是否成功的判断值为mkdirs
//        if( !dir1.exists() && !dir1.isDirectory()){
//            mkdirs = dir1.mkdirs();
//            log.info("是否创建文件夹成功：{}",mkdirs);
//        }
//        //判断路径下是否有该图片，有的话获取图片的大小（Byte）
//        if( dir2.exists()  && dir2.isFile()){
//            log.debug("本地已经存在图片了");
//            fileLength = dir2.length();
//            tupian = true;
//        }
//        try {
//            //对比从请求获取的图片和本地路径的图片大小是否一致，不一致则覆盖文件
//            if( fileLength != imageLength && mkdirs && imageLength > 0 ){
//                log.debug("执行了照片的覆盖");
//                os = new FileOutputStream(image);
//                os.write(body, 0, body.length);
//                os.flush();
//                os.close();
//                tupian = true;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return tupian;
//    }
//
//    /**
//     *  检查Token是否过期，如果过期重新生成。
//     */
//    private void refreshToken(){
//        Date date = new Date();
//        Long dateTmp = date.getTime();
//        Long difference = dateTmp - tokenValue.getGenerateTime();
//        if(difference >= tokenValue.getOvertime()){
//            log.info("token已经过期，重启获取token，当前时间戳：{}",dateTmp);
//            this.tokenValue = new EhrToken();
//        }
//    }
//
//    /**
//     * 用于处理从接口接受的json数据转换为LeadershipInfo类
//     * @param map REST接口接受的数据存为Map
//     * @return  LeadershipInfo类
//     */
//    private LeadershipInfo getInfoByMap(Map map){
//        LeadershipInfo info = new LeadershipInfo();
//
//        Map<String,Object> someInfo = mapper.SelectBasicPersonInfo(this.gh);
//        //获取基础的个人履历信息
//        BaseInfo baseInfo = new BaseInfo();
//        baseInfo.setXm((String) map.get("xm"));
//        baseInfo.setDw((String) someInfo.get("dep_name"));
//        baseInfo.setJg((String) map.get("jg"));
//        String jg = (String) map.get("jg");
//        baseInfo.setXb((String) map.get("xb"));
//        baseInfo.setZw((String) someInfo.get("mainpost"));
//        baseInfo.setZwjb((String) someInfo.get("zwzj"));
//        baseInfo.setCsrq((String) map.get("csrq"));
//        baseInfo.setGzrq((String) map.get("gzrq"));
//        baseInfo.setRdsj((String) map.get("rdsj"));
//        baseInfo.setZzmm((String) map.get("zzmm"));
//        baseInfo.setWy1((String) map.get("wy1"));
//        baseInfo.setWydj1((String) map.get("wydj1"));
//        baseInfo.setZyzg((String) map.get("zyzg"));
//        baseInfo.setZc((String) map.get("zc"));
//        baseInfo.setAge(String.valueOf(map.get("age")));
//        baseInfo.setYscj(getYscj());
//
//        //处理职业资格
//        List<Occupation> list = resumeMapper.getZhiyeZige(this.gh);
//        if(list.size() == 0){
//            Occupation occ = new Occupation();
//            occ.setName((String) map.get("zyzg"));
//            list.add(occ);
//        }
//        info.setOccupation(list);
//
//        //语言能力
//        List<Occupation> lanInfo = resumeMapper.getLanguage(this.gh);
//        if(lanInfo.size() == 0){
//            lanInfo.add(new Occupation());
//        }
//        info.setLanInfo(lanInfo);
//
//        //获取年度考评、教育经历、工作经历、奖励经历、惩罚经历的信息
//        ArrayList ndkpList = (ArrayList) map.get("ndkp");
//        ArrayList eduList = (ArrayList) map.get("RsEdu");
//        ArrayList workList = (ArrayList) map.get("RsWork");
//        ArrayList jlList = (ArrayList) map.get("jl");
//        ArrayList cfList = (ArrayList) map.get("cf");
//        ArrayList jtList = (ArrayList) map.get("RsFamily");
//
//        List<AnnualEvaluation> evaluations = new ArrayList<>();
//
//        //计算当前年份
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        for (int i = 1; i <= 4; i++) {
//            String nowYear = String.valueOf(year-i);
//            AnnualEvaluation one = new AnnualEvaluation();
//            one.setYear(nowYear);
//            for (int j = 0; j < ndkpList.size(); j++) {
//                ArrayList<String> content = (ArrayList<String>) ndkpList.get(j);
//                if (content.get(0).equals(nowYear)){
//                    one.setResult(content.get(1));
//                }
//            }
//            evaluations.add(one);
//        }
//        ObjectMapper mapper=new ObjectMapper();
//        String jsonStr = "/";
//        try {
//            jsonStr=mapper.writeValueAsString(evaluations);
//        } catch (JsonProcessingException e) {
//            log.error("将List<AnnualEvaluation> evaluations对象转为JSON失败！");
//            e.printStackTrace();
//        }
//        baseInfo.setNdkp(jsonStr);
//
//
////        List<StudyHistory> studys = new ArrayList<>();
////        if (eduList.size() == 0){
////            studys.add(new StudyHistory());
////        }
////        for (int i = 0; i < eduList.size(); i++) {
////            LinkedHashMap<String ,String> content = (LinkedHashMap) eduList.get(i);
////            StudyHistory one = new StudyHistory();
////            one.setXl(content.get("xl"));
////            one.setXw(content.get("xw"));
////            one.setByxx(content.get("byxx"));
////            one.setZy(content.get("zy"));
////            one.setRxsj(content.get("rxsj"));
////            one.setBysj(content.get("bysj"));
////            one.setXltype(content.get("xltype"));
////            studys.add(one);
////
////            if (i == 0){
////                baseInfo.setDyxl(content.get("xw"));
////            }
////            if (i == (eduList.size() - 1)  ){
////                baseInfo.setZgxl(content.get("xw"));
////            }
////        }
////        info.setEdu(studys);
//        String hmid = resumeMapper.selectHmid(this.gh);
//        List<StudyHistory> studys = resumeMapper.selectAllEdu(hmid);
//        if(studys.size() == 0){
//            studys.add(new StudyHistory());
//        }
//        info.setEdu(studys);
//
//        List<StudyHistory> edu = resumeMapper.selectEdu(hmid);
//        if(edu.size() > 0 ){
//            baseInfo.setZgxl(edu.get(0).getXl());
//            baseInfo.setDyxl(edu.get(1).getXl());
//        }else {
//            baseInfo.setDyxl("/");
//            baseInfo.setZgxl("/");
//        }
//
//
//
//        List<WorkHistory> works = new ArrayList<>();
//        if (workList.size() == 0){
//            works.add(new WorkHistory());
//        }
//        for (int i = 0; i < workList.size(); i++) {
//            ArrayList<String> content = (ArrayList<String>) workList.get(i);
//            WorkHistory one = new WorkHistory();
//            //判断担任职务时间，是否为“”，如果是“”则改为“至今”
//            if(content.get(1).equals("")){
//                one.setSdate(content.get(0));
//                one.setEdate("今");
//                one.setDrzw(content.get(2));
//            }else {
//                one.setSdate(content.get(0));
//                one.setEdate(content.get(1));
//                one.setDrzw(content.get(2));
//
//            }
//            works.add(one);
//        }
//        info.setWork(works);
//
//        List<Awards> awards = new ArrayList<>();
//        if (jlList.size() == 0){
//            awards.add(new Awards());
//        }
//        for (int i = 0; i < jlList.size(); i++) {
//            ArrayList<String> content = (ArrayList<String>) jlList.get(i);
//            Awards one = new Awards(content.get(0) ,content.get(1) , content.get(2), content.get(3));
//            awards.add(one);
//        }
//        info.setJl(awards);
//
//        List<Disposition> dispositions = new ArrayList<>();
//        if (cfList.size() == 0){
//            dispositions.add(new Disposition());
//        }
//        for (int i = 0; i < cfList.size(); i++) {
//            ArrayList<String> content = (ArrayList<String>) cfList.get(i);
//            Disposition one = new Disposition(content.get(0),content.get(1),content.get(2),content.get(3),content.get(4));
//            dispositions.add(one);
//        }
//        info.setCf(dispositions);
//
//        //家庭成员信息
//        List<FamilyInfo> familyInfos = new ArrayList<>();
//        if (jtList.size() == 0){
//            familyInfos.add(new FamilyInfo());
//        }else {
//            familyInfos =transFamilyList(jtList);
//        }
//        info.setJt(familyInfos);
//
//        info.setBaseInfo(baseInfo);
//
//        return info;
//    }
//
//    /**
//     * 获取雅思成绩
//     * @return
//     */
//    private String getYscj(){
//        String result = mapper.SelectLanguage(gh);
//        if (result == null){
//            return "/";
//        }else{
//            result = result.trim();
//        }
//        return result;
//    }
//
//    private List<FamilyInfo> transFamilyList(ArrayList jtList){
//        List<FamilyInfo> tmpList = new ArrayList<>();
//        //初始化数组
//        for (int i = 0; i < 9; i++) {
//            tmpList.add(null);
//        }
//        List<FamilyInfo> familyInfos = new ArrayList<>();
//        int sonIndex = 1;
//        int daughterIndex = 4;
//        /**
//         * 对tmpList的关系制定了存放位置。
//         * 配偶 0
//         * 儿子 1、2、3
//         * 女儿 4、5、6
//         * 父亲 7
//         * 母亲 8
//         */
//        for (int i = 0; i < jtList.size(); i++) {
//            ArrayList<String> content = (ArrayList<String>) jtList.get(i);
//            //获取与家庭成员的关系
//            String gx = matchFamilyRelation(content.get(0));
//            if(gx.equals("配偶")){
//                content.set(0,"配偶");
//                tmpList.add(0,transFamily(content));
//            }
//            if(gx.equals("儿子")){
//                content.set(0,"儿子");
//                tmpList.add(sonIndex,transFamily(content));
//                sonIndex++;
//            }
//            if(gx.equals("女儿")){
//                content.set(0,"女儿");
//                tmpList.add(daughterIndex,transFamily(content));
//                daughterIndex++;
//            }
//            if(gx.equals("父亲")){
//                content.set(0,"父亲");
//                tmpList.add(8,transFamily(content));
//            }
//            if(gx.equals("母亲")){
//                content.set(0,"母亲");
//                tmpList.add(9,transFamily(content));
//            }
//        }
//
//        //由于tmpList会有空值，所以遍历一遍，把数据存入familyInfos里面，消除空值
//        for (int i = 0; i < tmpList.size(); i++) {
//            if (tmpList.get(i) != null){
//                familyInfos.add(tmpList.get(i));
//            }
//        }
//        return familyInfos;
//    }
//
//    /**
//     * 匹配家庭关系
//     * @param relationName hr系统获取到的家庭关系
//     * @return 规范化为内容
//     */
//    private static String matchFamilyRelation(String relationName){
//        String res = "无";
//        switch (relationName){
//            case "妻子":
//            case "丈夫":
//            case "夫妻":
//            case "夫":
//            case "配偶":
//            case "妻":
//                return "配偶";
//            case "长子":
//            case "次子":
//            case "三子":
//            case "儿":
//            case "儿子":
//            case "子":
//                return "儿子";
//            case "长女":
//            case "次女":
//            case "三女":
//            case "女":
//            case "女儿":
//                return "女儿";
//            case "父亲":
//            case "父":
//            case "父女":
//            case "父子":
//                return "父亲";
//            case "母亲":
//            case "母":
//            case "母女":
//            case "母子":
//                return "母亲";
//        }
//        return res;
//    }
//
//    /**
//     * 将接收到的ArrayList转为FamilyInfo
//     * @param family
//     * @return
//     */
//    private FamilyInfo transFamily(ArrayList<String> family){
//        FamilyInfo familyInfo = new FamilyInfo();
//        familyInfo.setTitle(family.get(0));
//        familyInfo.setName(family.get(1));
//        if(family.get(2).equals("") || family.get(2) == null){
//            familyInfo.setBirthOfDate(family.get(2));
//        }else {
//            familyInfo.setBirthOfDate(family.get(2).substring(0,7));
//        }
//        familyInfo.setPolitics(family.get(3));
//        familyInfo.setPosition(family.get(4));
//        return familyInfo;
//    }
//
//
//}
//
///**
// * 获取Token值
// */
//@Slf4j
//class EhrToken{
//
//    private String dateTime;
//    private final String appKey = "1c429de1156639f26b35648b9c1e5e9c";
//    private String appappSecret;
//
//    //生成token的时间
//    private long generateTime;
//
//    //设置的过期时间为250s（毫秒单位）,实际过期时间为300s
//    private long overtime = 250000;
//
//    public EhrToken() {
//        Date nowDate = new Date();
//        generateTime = nowDate.getTime();
//        Map<String,String> times =  TimeChange.getTimeToToken();
//        this.dateTime = times.get("TimeSymbol");
//        this.appappSecret = md5Util.md5ThreeEncry( appKey+times.get("TimeNoSymbol"));
//        log.info("获取EHR的token值时间：{}",dateTime);
//    }
//
//
//    public String getDateTime() {
//        return dateTime;
//    }
//
//    public String getAppKey() {
//        return appKey;
//    }
//
//    public String getAppappSecret() {
//        return appappSecret;
//    }
//
//    public long getGenerateTime() {
//        return generateTime;
//    }
//
//    public long getOvertime() {
//        return overtime;
//    }
//
//    @Override
//    public String toString() {
//        return "EhrToken{" +
//                "dateTime='" + dateTime + '\'' +
//                ", appKey='" + appKey + '\'' +
//                ", appappSecret='" + appappSecret + '\'' +
//                '}';
//    }
//
//}
//
///**
// * 设置restTemplate可以支持text/html
// */
//class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//    public MyMappingJackson2HttpMessageConverter(){
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.TEXT_PLAIN);
//        mediaTypes.add(MediaType.TEXT_HTML);  //加入text/html类型的支持
//        setSupportedMediaTypes(mediaTypes);
//    }
//}
