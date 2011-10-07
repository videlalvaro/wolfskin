(ns wolfskin.core
  (:use [cljcr.core])
  (:import (org.apache.jackrabbit.core RepositoryFactoryImpl)))

(def repo-conf
     { RepositoryFactoryImpl/REPOSITORY_HOME "repository/repository"
      RepositoryFactoryImpl/REPOSITORY_CONF "repository/repository.xml"})

(defn new-article [data]
  (with-repository repo-conf
    (with-session {:username "username" :password "password" :save-changes true}
      (do
        (add-node (root-node) data)
        (println (node-at (root-node) data))
        (println (.getPath (node-at (root-node) data)))))))