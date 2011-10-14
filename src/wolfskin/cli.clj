(ns wolfskin.cli
  (:require [clojure.pprint :as pprint]
            [clojure.contrib.command-line :as ccl]
            [wolfskin.utils :as utils]
            ))

(defn -main [& args]
  (ccl/with-command-line args
    "Command line demo"
    [[url "Repository URL" "http://localhost:8080/rmi"]
     [username u "User Name" "admin"]
     [password p "User password", "admin"]
     [workspace w "JCR Workspace"]
     [sql? "Sets query as JCR_SQL2" true]
     [xpath? "Sets query as XPATH"]
     [query q "Query to execute"]]
    (let [qtype (if sql? :sql :xpath)
          nodes (utils/run-query url username password workspace qtype query)
          ]
      (pprint/pprint (utils/nodes-properties nodes)))))



