LIBDIR=/usr/lib

install:
	./gradlew shadowJar
	mv ./build/libs/kpigpio-*.jar ./
	mv ./kpigpio-*.jar ./kpigpio.jar
	mv ./kpigpio.jar ../
	cp ../kpigpio.jar $(LIBDIR)/kpigpio.jar

clean:
	rm -f ../kpigpio.jar
	rm -f $(LIBDIR)/kpigpio.jar
