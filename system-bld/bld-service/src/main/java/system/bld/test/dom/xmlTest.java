package system.bld.test.dom;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSON;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Map;

/**
 * @author litao
 * @date 2022-11-01
 * @Desc
 */
public class xmlTest {

    public static void main(String[] args) {

        String xmlStr= "<plist version=\"1.0\"><dict> <key>ICCID</key>        <string></string>       <key>IMEI</key> <string></string>       <key>NotOnConsole</key> <false/>        <key>PRODUCT</key>      <string>MacBookPro14,2</string> <key>UDID</key> <string>7A8ADA59-4718-5FA8-B725-8828D8B5C167</string>   <key>UserID</key>       <string>F450311D-D76D-401C-A287-8FA0353BA7E0</string>   <key>UserLongName</key> <string>R&amp;D</string>        <key>UserShortName</key>        <string>rd</string>     <key>VERSION</key>      <string>21G115</string></dict></plist>";
        Document document = XmlUtil.parseXml(xmlStr);

        Element rootElement =document.getDocumentElement();
        Element plistE = XmlUtil.getElement(rootElement,"plist");

        Element dictEe = XmlUtil.getElement(rootElement,"dict");

        //Map<String,Object> map = XmlUtil.xmlToMap(rootElement.getElementsByTagName("dict").item(0));
        NodeList nodeListkey = dictEe.getElementsByTagName("key");
        NodeList nodeListValue = dictEe.getElementsByTagName("string");

        for (int i = 0; i < nodeListkey.getLength(); i++) {
            Node node = nodeListkey.item(i);
            if("UDID".equals(node.getTextContent())){
                Node nodeUdid =  nodeListValue.item(i);
                if(nodeUdid!=null&& StrUtil.isNotBlank(nodeUdid.getTextContent())){
                    String udidStr =  nodeUdid.getTextContent();
                    System.out.println(udidStr);
                }

            }
            System.out.println("-------------");
        }

    }
}
