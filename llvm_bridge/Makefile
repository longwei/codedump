all: swiftcxx

swiftcxx: swiftcxx.o
	ld swiftcxx.o -force_load /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/arc/libarclite_macosx.a -framework CoreFoundation -syslibroot /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.12.sdk -lobjc -lSystem -arch x86_64 -L /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/swift/macosx -rpath /Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/swift/macosx -macosx_version_min 10.12.0 -no_objc_category_merging -o swiftcxx
	@echo "generate executable from object"
swiftcxx.o: swiftcxx.bc
	/usr/local/opt/llvm/bin/llc swiftcxx.bc -filetype=obj -o swiftcxx.o
	@echo "generate object file from bitcode"

swiftcxx.bc: main.bc magic.bc
	/usr/local/opt/llvm/bin/llvm-link main.bc magic.bc -o swiftcxx.bc
	@echo "combine two into one LLVM IR bitcode"

main.bc:
	swiftc -emit-bc main.swift -import-objc-header bridge.h -o main.bc
	@echo "LLVM IR of swift, pick up bridge.h for magic func"

magic.bc:
	clang++ -c -emit-llvm magic.cpp -o magic.bc
	@echo "LLVM IR of c++"


clean:
	rm swiftcxx swiftcxx.bc swiftcxx.o main.bc magic.bc