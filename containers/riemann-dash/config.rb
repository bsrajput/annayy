# Serve HTTP traffic on this port
set  :port, 4567
set :bind, "0.0.0.0"
config.store[:ws_config] = "~/Code/Clojure/annayy/containers/riemann-dash/config.json"
