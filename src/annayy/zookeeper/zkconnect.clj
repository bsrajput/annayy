(ns annayy.zookeeper.zkconnect
  (:require [zookeeper :as zk]
            [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]]))


(defn zkconnect [host port]
  (def zkclient (zk/connect (string/join ":" [host port]))))

(def zkcreate (zk/create zkclient "/parent-node" :persistent? true))

(defn zknodecreatepers [nodename]
  (zkcreate))

(def cli-options
  ;; An option with a required argument
  [["-p" "--port PORT" "Zookeeper Port Number"
    :default 2181
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ;; A non-idempotent option (:default is applied first)
   ["-H" "--host HOST" "Zookeeper Host"
    :id :verbosity
    :default 0
    :update-fn inc] ; Prior to 0.4.1, you would have to use:
   ;; :assoc-fn (fn [m k _] (update-in m [k] inc))
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])



(def cli-options
  [[ "-h" "--host host" "Z"
    :default "localhost"]

   ["-p" "--port port" "ZKPort"
    :default 2181]])

(defn -main [& args]
  (parse-opts args cli-options))
