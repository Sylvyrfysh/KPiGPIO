JAVA_HOME=/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt
CC=gcc
CFLAGS=-c -Wall -fPIC -I $(JAVA_HOME)/include -I $(JAVA_HOME)/include/linux
JAVACLASSDIR=./../kpigpio/build/classes/kotlin/main/
LIBDIR=/usr/lib
TARGETLIB=libKPiGPIOC.so
OBJECTS=KPiGPIOC.o

all: com_nicholaspjohnson_kpigpio_PiPGIO.h $(TARGETLIB)
	cp $(TARGETLIB) $(LIBDIR)

$(TARGETLIB): $(OBJECTS)
	gcc -shared -Wl,-soname,$@ -o $@ $(OBJECTS) -lpigpio -lpthread -lrt

com_nicholaspjohnson_kpigpio_PiPGIO.h:
	javah -cp $(JAVACLASSDIR) com.nicholaspjohnson.kpigpio.PiGPIO

%.o : %.c
	$(CC) $(CFLAGS) $<

clean:
	rm -f *.o $(TARGETLIB) com_nicholaspjohnson_kpigpio_PiPGIO.h $(LIBDIR)/$(TARGETLIB)

install: $(TARGETLIB)
	cp $< $(LIBDIR)
