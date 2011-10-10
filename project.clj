(defproject wolfskin "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure.contrib/zip-filter "1.3.0-SNAPSHOT"]
                 [org.clojure.contrib/command-line "1.3.0-SNAPSHOT"]
                 [javax.jcr/jcr "2.0"]
                 [org.apache.jackrabbit/jackrabbit-core "2.2.9"]
                 [org.apache.jackrabbit/jackrabbit-jcr-rmi "2.2.8"]
                 [cljcr/cljcr "1.0.0-SNAPSHOT"]
                 [org.slf4j/slf4j-log4j12 "1.5.8"]
                 ;[org.markdownj/markdownj "0.3.0-1.0.2b4"]
                 ]
  :run-aliases {:cli wolfskin.cli}
  :jvm-opts ["-Dfile.encoding=utf-8"])