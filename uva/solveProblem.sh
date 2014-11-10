#! /bin/bash

authur="Liang Li <ll@lianglee.org>";
comments=\
'/*
 *  Copyright (c) 2014 Liang Li <ll@lianglee.org>. All rights reserved.
 *
 *  This program is a free software and released under the BSD license.
 *  https://github.com/lang010/acit
 *
 *  Solutions for UVa Problem %d
 *  UVa link: %s
 *
 *  @Authur %s
 *  @Date %s
 */\n';

problemId=12;

function getUvaLink() {
    id=$1;
    end=${id:(-2)};
    echo "http://uva.onlinejudge.org/external/${id%$end}/$id.html"; 
}

function addComments() {
    problemId=$1;
    sourceFile="$problemId/Main.java";
    uvaLink=`getUvaLink $problemId`
    if [ -f $sourceFile ]
    then
        head=`head -1 $sourceFile`;
        if [ "/*" != "$head" ]
        then
            echo "Add comments to $sourceFile";
            date=`stat -f "%Sm" $sourceFile`;
            tmpFile="${sourceFile}.tmp";
            printf "$comments" "$problemId" "$uvaLink" "$authur" "$date" > $tmpFile;
            cat $sourceFile >> $tmpFile;
            mv $tmpFile $sourceFile;
        else
            echo "Found comments in $sourceFile, Ignored.";
        fi
    else
        echo "Not Found file: $sourceFile";
    fi;

}

function addCommentsForSolutions() {
    for id in `ls`; do
        addComments $id;
    done
}

if [ "$1" == "" ]
then
    echo "Usage: ./solveProblem.sh problemId";
    exit 1;
fi

problemId=$1;

if [ -d $problemId ]
then
    echo "Direction $problemId exists, ignored"
    exit 0;
fi

template="Main.java";
mkdir $problemId && cp "$template" "$problemId" && addComments $problemId
if [ $? == "0" ]
then
    echo "New file $problemId/$template created. Hacking.";
fi
