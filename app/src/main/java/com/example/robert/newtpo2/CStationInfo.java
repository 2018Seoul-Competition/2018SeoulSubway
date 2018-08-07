package com.example.robert.newtpo2;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * Created by Robert on 2018-08-07.
 */
public class CStationInfo {
    private String m_strStationName;
    private String m_strLineNum;
    private Boolean m_bInfoExist = false;

    public void getStationInfo() {
        CNetworkTask networkTask = new CNetworkTask();
        String strXMLData = "";

        //FIXME : for debugging
        m_strStationName = "교대";
        m_strLineNum = "2";
        networkTask.setStationName(m_strStationName);
        networkTask.setMethod("realtimeStationArrival");
        try {
            strXMLData = networkTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        strXMLData = DUMPDATA;
        //parse xml data to
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputSource is = new InputSource(new StringReader(strXMLData));
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            Node codeNode = document.getElementsByTagName("code").item(0);

            if(codeNode.getTextContent().compareTo("INFO-000") == 0){
                m_bInfoExist = true;

            }



        } catch(Exception e){

        }
    }

    public void setStationName(String strStationName) {
        m_strStationName = strStationName;
    }

    public void setLineNum(String strLineNum) {
        m_strLineNum = strLineNum;
    }

    private String DUMPDATA = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><realtimeStationArrival><RESULT><code>INFO-000</code><developerMessage></developerMessage><link></link><message>정상 처리되었습니다.</message><status>200</status><total>8</total></RESULT><row><rowNum>1</rowNum><selectedCount>5</selectedCount><totalCount>8</totalCount><subwayId>1002</subwayId><updnLine>외선</updnLine><trainLineNm>성수행 - 강남방면</trainLineNm><subwayHeading>오른쪽</subwayHeading><statnFid>1002000222</statnFid><statnTid>1002000224</statnTid><statnId>1002000223</statnId><statnNm>교대</statnNm><ordkey>01001성수종착0</ordkey><subwayList>1002,1003</subwayList><statnList>1002000223,1003000340</statnList><barvlDt>72</barvlDt><btrainNo>2273</btrainNo><bstatnId>14</bstatnId><bstatnNm>성수</bstatnNm><recptnDt>2018-08-07 14:19:30.0</recptnDt><arvlMsg2>전역 도착</arvlMsg2><arvlMsg3>서초</arvlMsg3><arvlCd>5</arvlCd></row><row><rowNum>2</rowNum><selectedCount>5</selectedCount><totalCount>8</totalCount><subwayId>1003</subwayId><updnLine>상행</updnLine><trainLineNm>구파발행 - 고속터미널방면</trainLineNm><subwayHeading>오른쪽</subwayHeading><statnFid>1003000339</statnFid><statnTid>1003000341</statnTid><statnId>1003000340</statnId><statnNm>교대</statnNm><ordkey>01002구파발0</ordkey><subwayList>1002,1003</subwayList><statnList>1002000223,1003000340</statnList><barvlDt>278</barvlDt><btrainNo>3226</btrainNo><bstatnId>26</bstatnId><bstatnNm>구파발</bstatnNm><recptnDt>2018-08-07 14:19:14.0</recptnDt><arvlMsg2>4분 38초 후 (양재)</arvlMsg2><arvlMsg3>양재</arvlMsg3><arvlCd>99</arvlCd></row><row><rowNum>3</rowNum><selectedCount>5</selectedCount><totalCount>8</totalCount><subwayId>1002</subwayId><updnLine>외선</updnLine><trainLineNm>성수행 - 강남방면</trainLineNm><subwayHeading>오른쪽</subwayHeading><statnFid>1002000222</statnFid><statnTid>1002000224</statnTid><statnId>1002000223</statnId><statnNm>교대</statnNm><ordkey>02003성수종착0</ordkey><subwayList>1002,1003</subwayList><statnList>1002000223,1003000340</statnList><barvlDt>297</barvlDt><btrainNo>2275</btrainNo><bstatnId>16</bstatnId><bstatnNm>성수</bstatnNm><recptnDt>2018-08-07 14:19:30.0</recptnDt><arvlMsg2>4분 57초 후</arvlMsg2><arvlMsg3>사당</arvlMsg3><arvlCd>99</arvlCd></row><row><rowNum>4</rowNum><selectedCount>5</selectedCount><totalCount>8</totalCount><subwayId>1003</subwayId><updnLine>상행</updnLine><trainLineNm>대화행 - 고속터미널방면</trainLineNm><subwayHeading>오른쪽</subwayHeading><statnFid>1003000339</statnFid><statnTid>1003000341</statnTid><statnId>1003000340</statnId><statnNm>교대</statnNm><ordkey>02006대화0</ordkey><subwayList>1002,1003</subwayList><statnList>1002000223,1003000340</statnList><barvlDt>682</barvlDt><btrainNo>3228</btrainNo><bstatnId>30</bstatnId><bstatnNm>대화</bstatnNm><recptnDt>2018-08-07 14:19:14.0</recptnDt><arvlMsg2>11분 22초 후 (학여울)</arvlMsg2><arvlMsg3>학여울</arvlMsg3><arvlCd>99</arvlCd></row><row><rowNum>5</rowNum><selectedCount>5</selectedCount><totalCount>8</totalCount><subwayId>1002</subwayId><updnLine>내선</updnLine><trainLineNm>성수행 - 서초방면</trainLineNm><subwayHeading>왼쪽</subwayHeading><statnFid>1002000222</statnFid><statnTid>1002000224</statnTid><statnId>1002000223</statnId><statnNm>교대</statnNm><ordkey>11002성수종착0</ordkey><subwayList>1002,1003</subwayList><statnList>1002000223,1003000340</statnList><barvlDt>260</barvlDt><btrainNo>3260</btrainNo><bstatnId>11</bstatnId><bstatnNm>성수</bstatnNm><recptnDt>2018-08-07 14:19:30.0</recptnDt><arvlMsg2>4분 20초 후</arvlMsg2><arvlMsg3>역삼</arvlMsg3><arvlCd>99</arvlCd></row></realtimeStationArrival>";
}

class CStationSubwayInfo{
    private String m_strSubwayId;       //지하철호선ID
    private String m_strUpdnLine;       //상행, 하행, 외선순환, 내선순환
    private String m_strTrainLineNm;    //어디행 - 방면
    private String m_strBarvIDt;        //열차도착예정시간
    private String m_strRecptnDt;       //열차도착정보 생성 시간
    private String m_strArvlMsg2;       //도착메시지 - 전역 진입, 전역 도착 등
    private String m_strArvlMsg3;       //도착메시지 - 종합운동장 도착, 12분후 (광명사거리) 등
    private String m_strArvlCd;         //도착코드 (0: 진입, 1: 도착, 2: 출발, 3: 전역출발, 4:전역진입, 5:전역도착, 99:운행중)

    //constructor
    public CStationSubwayInfo(String strSubwayId, String strUpdnLine, String strTrainLineNm, String strBarvIDt, String strRecptnDt, String strArvlMsg2, String strArvlMsg3, String strArvlCd){
        m_strSubwayId = strSubwayId;
        m_strUpdnLine = strUpdnLine;
        m_strTrainLineNm = strTrainLineNm;
        m_strBarvIDt = strBarvIDt;
        m_strRecptnDt = strRecptnDt;
        m_strArvlMsg2 = strArvlMsg2;
        m_strArvlMsg3 = strArvlMsg3;
        m_strArvlCd = strArvlCd;
    }
}

