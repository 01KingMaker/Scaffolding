#!/bin/sh

if [ "$#" -lt 8 ]; then
    echo "Usage: $0 --library <library> --language <language> --outputdirectory <outputdirectory> --package <package> --table <table>"
    exit 1
fi

while [ "$#" -gt 0 ]; do
    case "$1" in
        -p|--library)
            library="$2"
            shift 2
            ;;
        -l|--language)
            language="$2"
            shift 2
            ;;
        -out|--outputdirectory)
            outputdirectory="$2"
            shift 2
            ;;
        --package)
            package="$2"
            shift 2
            ;;
        -t|--table)
            table="$2"
            shift 2
            ;;
        *)
            echo "Invalid option: $1"
            exit 1
            ;;
    esac
done

if [ -z "$library" ] || [ -z "$language" ] || [ -z "$outputdirectory" ] || [ -z "$package" ] || [ -z "$table" ]; then
    echo "Toutes les options (--database, --user, --library, --language, --outputdirectory, --package, --table) sont obligatoires."
    exit 1
fi

java -cp "$library/*" src.scaff.Scaff "$library" "$language" "$outputdirectory" "$package" "$table"