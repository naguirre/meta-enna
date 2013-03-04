for i in *.cfg ; do
   eet -d $i config $(echo $i | sed s:cfg:src:g) 1
done

