package com.mirage.dataingest;

/**
 * Definition of constant in project.
 * The following fields was defined:
 * 1. Exchange name for data exchange
 * 2. Data queue name for RabbitMQ
 * 3. Routing key for history consumer (database)
 * 4. Routing key for real time display consumer
 *
 * @author BorisMirage
 * Time: 2019/12/23 16:51
 * Created with IntelliJ IDEA
 */

public class Constants {

    public static final String EXCHANGE_NAME = "FitnessDataExchange";

    public static final String QUEUE_NAME = "FitnessDataQueue";

    public static final String ROUTING_KEY_HISTORY = "fitnessdata.history";

    public static final String ROUTING_KEY_REALTIME = "fitnessdata.realtime";
}
