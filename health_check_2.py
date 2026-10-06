# Connected = all ip addresses connections has been OK ! 
# Disconnected =  all ip addresses connections has been failed !!
# Corrupted = session is correct but the pipeline no because of the previous missing connections (probably it's going to fail)

import logging
import subprocess

counter = 0
log_file = "C:\\Users\\Dell_USA\\Desktop\\base.log.txt"
state_1,state_2,state_3 = "Disconnected","Corrupted","Connected"
clients = {"8.8.8.8":"Unknown",
        "192.168.2.1":"Unknown",
        "127.0.0.1":"Unknown"}

logging.basicConfig(filename=log_file,level=logging.DEBUG,
                    filemode="a",
                    format=" %(levelname)s - %(asctime)s - %(name)s --> %(message)s")

def health_check(ip_address):
    global counter
    command = ["ping",ip_address]
    ping_command = subprocess.run(command,capture_output=True,text=True,timeout=5)
    #exit_code => ping_command = subprocess.call(command)
    if ping_command.returncode == 0 :
        logging.info(
                f"HEALTH CHECK SUCCESS - IP={ip_address} - STATUS=Connected"
        )
        statement(ip=ip_address,state=ping_command.returncode)
    else :
        logging.warning(
                f"HEALTH CHECK FAILED - IP={ip_address} "
                f"- STATUS=Disconnected - RETURN_CODE={ping_command.returncode}"
        )
        counter+=1
        statement(ip=ip_address,state=ping_command.returncode)

def statement(ip,state):
    global counter
    if state != 0 :
        clients.update({ip:state_1})
        logging.debug(f"state SET - {ip}:{state_1}")
    elif state == 0 and counter != 0:
        clients.update({ip:state_2})
        logging.debug(f"state SET - {ip}:{state_2}")
    elif state == 0 and counter == 0:
        clients.update({ip:state_3})
        logging.debug(f"state SET - {ip}:{state_3}")

try:
    for key in clients.keys():
        health_check(ip_address=key)
except FileNotFoundError as e:
    logging.error(f"COMMAND OR FILES NOT FOUND: {e}")
except PermissionError as e:
    logging.error( f"HEALTH CHECK ERROR - IP={key} "
                  f"PERMISSION DENIED WHILE EXECUTING PING - DETAILS : {e}")
except subprocess.TimeoutExpired as e:
    logging.error( f"HEALTH CHECK ERROR - IP={key} "
                  f"PING TIMEOUT - DETAILS : {e}")
except subprocess.SubprocessError as e:
    logging.error( f"HEALTH CHECK ERROR - IP={key} "
                  f"SUBPROCESS ERROR - DETAILS : {e}")
except OSError as e:
    logging.error( f"HEALTH CHECK ERROR - IP={key} "
                  f"ERROR WHILE EXECUTING PING - DETAILS : {e}")

finally :
    print(clients.items())
    logging.info("HEALTH-CHECK Done !!!\n"
                f" CHECK THE LOGS --> [{log_file}]"
f"\n=====================================================================")

