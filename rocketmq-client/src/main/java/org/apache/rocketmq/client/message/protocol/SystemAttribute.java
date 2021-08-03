package org.apache.rocketmq.client.message.protocol;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.apache.rocketmq.client.remoting.Endpoints;

@Data
public class SystemAttribute {
    private String tag;
    private final List<String> keys;
    private String messageId;
    private Digest digest;
    private Encoding bodyEncoding;
    private MessageType messageType = MessageType.NORMAL;
    private long bornTimeMillis;
    private String bornHost;
    private long deliveryTimeMillis = 0;
    private int delayLevel = 0;
    private String receiptHandle;
    private int partitionId;
    private long partitionOffset;
    private long invisiblePeriod;
    private int deliveryAttempt;
    private String producerGroup;
    private String messageGroup;
    private String traceContext;
    private String transactionId;
    private long transactionResolveDelayMillis;
    // Would set after receiving the message.
    private long decodedTimestamp;
    private Endpoints ackEndpoints;

    public SystemAttribute() {
        this.keys = new ArrayList<String>();
    }

    public void setKeys(List<String> keys) {
        this.keys.clear();
        this.keys.addAll(keys);
    }

    public void setKey(String key) {
        this.keys.clear();
        this.keys.add(key);
    }
}
