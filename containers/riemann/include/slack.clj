(def credentials {:account "EngineerToBe", :token "53CR3T"})
(def slacker (slack credentials {:username "Riemann bot"
                                 :channel "#engineertobe"
                                 :icon ":smile:"}))
