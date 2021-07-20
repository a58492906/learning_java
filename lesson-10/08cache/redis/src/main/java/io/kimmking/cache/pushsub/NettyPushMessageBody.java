package io.kimmking.cache.pushsub;

import java.io.Serializable;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-07-20 15:49
 */
public class NettyPushMessageBody implements Serializable {

    private String userId;

    private String message;
    private String topic;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "NettyPushMessageBody{" +
                "userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
