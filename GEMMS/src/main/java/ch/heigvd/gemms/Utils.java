package ch.heigvd.gemms;

import ch.heigvd.layer.IGEMMSNode;
import javafx.scene.Node;

import java.io.*;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by lognaume on 5/23/17.
 */
public class Utils {
    public static String serializeNodeList(List<Node> nodes) throws IOException {
        String ret;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzipOut = new GZIPOutputStream(baos);
        ObjectOutputStream out = new ObjectOutputStream(gzipOut);

        List<IGEMMSNode> n = new LinkedList<>();
        nodes.forEach(node -> n.add((IGEMMSNode)node));
        out.writeObject(n);
        out.close();

        ret = Base64.getEncoder().encodeToString(baos.toByteArray());

        return ret;
    }

    public static List<Node> deserializeNodeList(String serialized) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.getDecoder().decode(serialized));
        GZIPInputStream gzipInputStream = new GZIPInputStream(bais);
        ObjectInputStream in = new ObjectInputStream(gzipInputStream);
        List<Node> ret = (List<Node>)in.readObject();
        in.close();
        return ret;
    }
}
