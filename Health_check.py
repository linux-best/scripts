"""level-1"""
#import subprocess
#import socket
#index = 0
#
#def a(x):
#    if x == 0 :
#        print("ok")
#    else:
#        print("not ok")
#
#def health_check(ip_address):
#    global index
#    command = ["ping",ip_address,"-c","4"]
#    ping_command = subprocess.run(command,capture_output=True,text=True)
#    #exit_code = ping_command = subprocess.call(command)
#    if ping_command.returncode != 0 :
#        index+=1
#    
#lst = ["8.8.8.8","192.168.1.7"]
#for i in lst:
#    health_check(ip_address=i)
#a(index)

# =====================================================================

"""level-2"""
import subprocess
index,counter = 0

def health_check(ip_address):
    global index
    command = ["ping",ip_address]
    ping_command = subprocess.run(command,capture_output=True,text=True)
    #exit_code = ping_command = subprocess.call(command)
    if ping_command.returncode == 0 :
        print("Connection is ok ",[ip_address])
        a()
    else :
        print("Connection isn't ok",[ip_address])
        index+=1
        a()

def a(x=index):
    if x == 0 :
        return 0
    else:
        return 1

lst = ["8.8.8.8","127.0.0.1"]

for i in lst:
    health_check(ip_address=i)
