(ns wolfskin.utils
  (:require [cljcr.core :as jcr]
            [cljcr.rmi :as rmi]))

(defn run-query [url username password ws-name qtype statement]
  (let [repo (rmi/get-repository url)
        credentials (rmi/get-credentials username password)
        session (rmi/get-session repo credentials ws-name)
        workspace (rmi/get-workspace session)
        qm (rmi/get-query-manager workspace)
        language (rmi/get-query-type qtype)]
    (rmi/get-nodes (rmi/execute (rmi/create-query qm statement language)))))

(defn nodes-properties [nodes]
  (map #(jcr/get-property-map (jcr/properties %)) nodes))