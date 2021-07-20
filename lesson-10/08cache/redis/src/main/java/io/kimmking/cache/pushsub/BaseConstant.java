package io.kimmking.cache.pushsub;

/**
 * @author xjm
 * @version 1.0
 * @date 2021-07-20 15:52
 */

public class BaseConstant {

    /**
     * redis发布订阅topic：发送给指定用户
     */
    public static final String PUSH_MESSAGE_TO_ONE = "PushMessageToOne";

    /**
     * redis发布订阅topic：发送给所有用户
     */
    public static final String PUSH_MESSAGE_TO_ALL = "PushMessageToAll";

}
