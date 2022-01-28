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
//    //�Ƿ���Ի���
//    private boolean isCeshi;
//    private String PHOTO_PATH;
//    private String UPLOAD_DIR;
//
//    String gh="";
//
//    public LeadershipInfoServiceImpl() {
//        this.tokenValue = new EhrToken();
//        log.info("��ǰ�Ļ���Ϊ��{}",runtimeEnv);
//
//        //���Ի����ı���ͼƬ·������ʽ����·����ͬ������Ҫ�жϵ�ǰ����
//        if(runtimeEnv.equals("dev")){
//            isCeshi = false;
//            PHOTO_PATH = "http://cadresinfo.sinotruk.com:8001/cadrephoto/";
//            UPLOAD_DIR = "/home/sinotruk/cadrephoto";
//        }else{
//            isCeshi = true;
////            PHOTO_PATH = "http://223.99.1.153:8890/photo/";���ԸĶ�
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
//            log.error("ResourceAccessException��������ʧ�ܣ������ݻ�ʱ����ʱ��Ϣ{}",e.getMessage());
//            return new LeadershipInfo();
//        }catch (Exception e){
//            log.error("Exception��������ʧ�ܣ��쳣��Ϣ:{},�쳣��Cause��Ϣ��{},�쳣StackTrace��Ϣ��{}" ,e.getMessage(),e.getCause(),e.getStackTrace());
//            return new LeadershipInfo();
//        }
//
//        if (result == null){
//            return new LeadershipInfo();
//        }
//
//        LeadershipInfo leadershipInfo = getInfoByMap(result.getBody());
//        //������Ƭ��������ӵ�leadershipInfo�ڡ�
//        boolean isSuccess = postPhoto(gh);
//        if(isSuccess){
//            leadershipInfo.getBaseInfo().setPhoto(PHOTO_PATH+gh+".jpg");
//        }
//        return leadershipInfo;
//    }
//
//    /**
//     * ���빤�Ż�ȡͼƬ
//     * @param gh ����
//     * @return trueΪ����ͼƬ�ɹ���falseΪʧ��
//     */
//    public boolean postPhoto(String gh){
//        //����ֵ���ж��ļ������Ƿ���ͼƬ
//        boolean tupian = false;
//        long imageLength = 0L;
//        byte[] body = new byte[0];
//        try {
//            //����ͼƬ
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
//            System.out.println("����ʧ��");
//        }catch (Exception e){
//            System.out.println("ALL����ʧ��");
//        }
//        //���ͼƬ
//        OutputStream os;
//        String uploadDir = UPLOAD_DIR;
//
//        String image;
//        //�жϵ�ǰ�Ƿ��ǲ��Ի�������Ϊ���Ի�����windwos�£�����ʽ������linux�£������ļ�·��������ͬ
//        if (isCeshi){
//            image = uploadDir+"\\"+gh+".jpg";
//        }else{
//            image = uploadDir+"/"+gh+".jpg";
//        }
//
//        log.info("Ԥ�ƴ洢��Ƭ���ļ��У�{}��·����{}",uploadDir,image);
//        File dir1 = new File(uploadDir);
//        File dir2 = new File(image);
//        long fileLength = 0L;
//        boolean mkdirs = true;
//
//        //�ж�uploadDir·���Ƿ���ڣ��������򴴽��������ļ����Ƿ�ɹ����ж�ֵΪmkdirs
//        if( !dir1.exists() && !dir1.isDirectory()){
//            mkdirs = dir1.mkdirs();
//            log.info("�Ƿ񴴽��ļ��гɹ���{}",mkdirs);
//        }
//        //�ж�·�����Ƿ��и�ͼƬ���еĻ���ȡͼƬ�Ĵ�С��Byte��
//        if( dir2.exists()  && dir2.isFile()){
//            log.debug("�����Ѿ�����ͼƬ��");
//            fileLength = dir2.length();
//            tupian = true;
//        }
//        try {
//            //�Աȴ������ȡ��ͼƬ�ͱ���·����ͼƬ��С�Ƿ�һ�£���һ���򸲸��ļ�
//            if( fileLength != imageLength && mkdirs && imageLength > 0 ){
//                log.debug("ִ������Ƭ�ĸ���");
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
//     *  ���Token�Ƿ���ڣ���������������ɡ�
//     */
//    private void refreshToken(){
//        Date date = new Date();
//        Long dateTmp = date.getTime();
//        Long difference = dateTmp - tokenValue.getGenerateTime();
//        if(difference >= tokenValue.getOvertime()){
//            log.info("token�Ѿ����ڣ�������ȡtoken����ǰʱ�����{}",dateTmp);
//            this.tokenValue = new EhrToken();
//        }
//    }
//
//    /**
//     * ���ڴ���ӽӿڽ��ܵ�json����ת��ΪLeadershipInfo��
//     * @param map REST�ӿڽ��ܵ����ݴ�ΪMap
//     * @return  LeadershipInfo��
//     */
//    private LeadershipInfo getInfoByMap(Map map){
//        LeadershipInfo info = new LeadershipInfo();
//
//        Map<String,Object> someInfo = mapper.SelectBasicPersonInfo(this.gh);
//        //��ȡ�����ĸ���������Ϣ
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
//        //����ְҵ�ʸ�
//        List<Occupation> list = resumeMapper.getZhiyeZige(this.gh);
//        if(list.size() == 0){
//            Occupation occ = new Occupation();
//            occ.setName((String) map.get("zyzg"));
//            list.add(occ);
//        }
//        info.setOccupation(list);
//
//        //��������
//        List<Occupation> lanInfo = resumeMapper.getLanguage(this.gh);
//        if(lanInfo.size() == 0){
//            lanInfo.add(new Occupation());
//        }
//        info.setLanInfo(lanInfo);
//
//        //��ȡ��ȿ������������������������������������ͷ���������Ϣ
//        ArrayList ndkpList = (ArrayList) map.get("ndkp");
//        ArrayList eduList = (ArrayList) map.get("RsEdu");
//        ArrayList workList = (ArrayList) map.get("RsWork");
//        ArrayList jlList = (ArrayList) map.get("jl");
//        ArrayList cfList = (ArrayList) map.get("cf");
//        ArrayList jtList = (ArrayList) map.get("RsFamily");
//
//        List<AnnualEvaluation> evaluations = new ArrayList<>();
//
//        //���㵱ǰ���
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
//            log.error("��List<AnnualEvaluation> evaluations����תΪJSONʧ�ܣ�");
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
//            //�жϵ���ְ��ʱ�䣬�Ƿ�Ϊ����������ǡ������Ϊ������
//            if(content.get(1).equals("")){
//                one.setSdate(content.get(0));
//                one.setEdate("��");
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
//        //��ͥ��Ա��Ϣ
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
//     * ��ȡ��˼�ɼ�
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
//        //��ʼ������
//        for (int i = 0; i < 9; i++) {
//            tmpList.add(null);
//        }
//        List<FamilyInfo> familyInfos = new ArrayList<>();
//        int sonIndex = 1;
//        int daughterIndex = 4;
//        /**
//         * ��tmpList�Ĺ�ϵ�ƶ��˴��λ�á�
//         * ��ż 0
//         * ���� 1��2��3
//         * Ů�� 4��5��6
//         * ���� 7
//         * ĸ�� 8
//         */
//        for (int i = 0; i < jtList.size(); i++) {
//            ArrayList<String> content = (ArrayList<String>) jtList.get(i);
//            //��ȡ���ͥ��Ա�Ĺ�ϵ
//            String gx = matchFamilyRelation(content.get(0));
//            if(gx.equals("��ż")){
//                content.set(0,"��ż");
//                tmpList.add(0,transFamily(content));
//            }
//            if(gx.equals("����")){
//                content.set(0,"����");
//                tmpList.add(sonIndex,transFamily(content));
//                sonIndex++;
//            }
//            if(gx.equals("Ů��")){
//                content.set(0,"Ů��");
//                tmpList.add(daughterIndex,transFamily(content));
//                daughterIndex++;
//            }
//            if(gx.equals("����")){
//                content.set(0,"����");
//                tmpList.add(8,transFamily(content));
//            }
//            if(gx.equals("ĸ��")){
//                content.set(0,"ĸ��");
//                tmpList.add(9,transFamily(content));
//            }
//        }
//
//        //����tmpList���п�ֵ�����Ա���һ�飬�����ݴ���familyInfos���棬������ֵ
//        for (int i = 0; i < tmpList.size(); i++) {
//            if (tmpList.get(i) != null){
//                familyInfos.add(tmpList.get(i));
//            }
//        }
//        return familyInfos;
//    }
//
//    /**
//     * ƥ���ͥ��ϵ
//     * @param relationName hrϵͳ��ȡ���ļ�ͥ��ϵ
//     * @return �淶��Ϊ����
//     */
//    private static String matchFamilyRelation(String relationName){
//        String res = "��";
//        switch (relationName){
//            case "����":
//            case "�ɷ�":
//            case "����":
//            case "��":
//            case "��ż":
//            case "��":
//                return "��ż";
//            case "����":
//            case "����":
//            case "����":
//            case "��":
//            case "����":
//            case "��":
//                return "����";
//            case "��Ů":
//            case "��Ů":
//            case "��Ů":
//            case "Ů":
//            case "Ů��":
//                return "Ů��";
//            case "����":
//            case "��":
//            case "��Ů":
//            case "����":
//                return "����";
//            case "ĸ��":
//            case "ĸ":
//            case "ĸŮ":
//            case "ĸ��":
//                return "ĸ��";
//        }
//        return res;
//    }
//
//    /**
//     * �����յ���ArrayListתΪFamilyInfo
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
// * ��ȡTokenֵ
// */
//@Slf4j
//class EhrToken{
//
//    private String dateTime;
//    private final String appKey = "1c429de1156639f26b35648b9c1e5e9c";
//    private String appappSecret;
//
//    //����token��ʱ��
//    private long generateTime;
//
//    //���õĹ���ʱ��Ϊ250s�����뵥λ��,ʵ�ʹ���ʱ��Ϊ300s
//    private long overtime = 250000;
//
//    public EhrToken() {
//        Date nowDate = new Date();
//        generateTime = nowDate.getTime();
//        Map<String,String> times =  TimeChange.getTimeToToken();
//        this.dateTime = times.get("TimeSymbol");
//        this.appappSecret = md5Util.md5ThreeEncry( appKey+times.get("TimeNoSymbol"));
//        log.info("��ȡEHR��tokenֵʱ�䣺{}",dateTime);
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
// * ����restTemplate����֧��text/html
// */
//class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//    public MyMappingJackson2HttpMessageConverter(){
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.TEXT_PLAIN);
//        mediaTypes.add(MediaType.TEXT_HTML);  //����text/html���͵�֧��
//        setSupportedMediaTypes(mediaTypes);
//    }
//}
