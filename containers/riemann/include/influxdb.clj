(def influxdb-credentials {:version :1.7.2
                           :host "influxdb"
                           :username "hawkeye"
                           :password "riemann"
                           :port 8086
                           :scheme "http"
                           :db "monitoring"})



(def sendtoinfluxdb
  (batch 100 1/10
         (async-queue! :agg {:queue-size 1000
                             :core-pool-size 1
                             :max-pool-size 4
                             :keep-alive-time 60000}
                       (influxdb influxdb-credentials))))
