#!/usr/bin/env python
'''
**********************************************************************
* Filename    : ultra_sonic_avoidance.py
* Description : An example for sensor car kit to followe light
* Author      : Dream
* Brand       : SunFounder
* E-mail      : service@sunfounder.com
* Website     : www.sunfounder.com
* Update      : Dream    2016-09-27    New release
**********************************************************************
'''

import time
import TB6612
import back_wheels

force_turning = 0    # 0 = random direction, 1 = force left, 2 = force right, 3 = orderdly

picar.setup()

bw = back_wheels.Back_Wheels(db='config')
fw.turning_max = 45

forward_speed = 70
backward_speed = 70

back_distance = 10
turn_distance = 20

timeout = 10
last_angle = 90
last_dir = 0

def start_avoidance():
	print('start_avoidance')

	while True:
		bw.speed = backward_speed
        bw.backward()
	    time.sleep(1)
		bw.forward()
		time.sleep(1)
			

def stop():
	bw.stop()
	fw.turn_straight()

if __name__ == '__main__':
	try:
		start_avoidance()
	except KeyboardInterrupt:
		stop()