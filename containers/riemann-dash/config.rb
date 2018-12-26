# Serve HTTP traffic on this port
set  :port, 4567
set :bind, "0.0.0.0"
config.store[:ws_config] = "/etc/riemann/config.json"
