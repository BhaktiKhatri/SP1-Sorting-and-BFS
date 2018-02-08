#!/bin/bash

echo "Welcome to Sorting comparison project."

#lenMax=16000000
iter=6
start=1
arrSize=$((lenMax/iter))
for (( i=$start; i<=$iter; i++ ))
do
   echo "Run$i:"
   echo "***********************************"
   #size=$((arrSize * i))
   size=$((16**i))
   for j in 1 2 3
   do
   	java g45.Q1.Driver $size $j &
	PROC_ID=$!
	count=0 
   	while kill -0 "$PROC_ID" >/dev/null 2>&1
	do
	    sleep 1
	    count=$((count+1))
	    if [ $count -gt 120 ]
   	    then
		kill $! 2>/dev/null && echo "Running time more than two minutes: Abort"
	    fi
   	done
   done
done
