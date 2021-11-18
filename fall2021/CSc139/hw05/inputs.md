# Inputs and Outputs for Homework 5 - Alec Resha

- [Inputs and Outputs for Homework 5 - Alec Resha](#inputs-and-outputs-for-homework-5---alec-resha)
  - [./cli pwd, ls](#cli-pwd-ls)
  - [./cli notACommand, ls, touch temp.txt, ls](#cli-notacommand-ls-touch-temptxt-ls)
  - [./cli ls, mv temp.txt temp2.txt, ls, rm temp2.txt, ls](#cli-ls-mv-temptxt-temp2txt-ls-rm-temp2txt-ls)
  - [echo "echo \"\n\nStart sh file \n\n\"; ./cli pwd, ls; echo \"\n\nEnd of sh output\n\n\"" >> temp.sh; ./cli more temp.sh, sh ./temp.sh, ls, pwd, rm temp.sh, ls](#echo-echo-nnstart-sh-file-nn-cli-pwd-ls-echo-nnend-of-sh-outputnn--tempsh-cli-more-tempsh-sh-tempsh-ls-pwd-rm-tempsh-ls)

## ./cli pwd, ls

AlecResha - cli - 11/18/2021  
Legal commands: cd exec exit gcc ls man more mv rm pwd sh touch which $PATH   
3 strings passed to argv  
cmd:  pwd  
/home/alec/notesRepo/fall2021/CSc139/hw05  
cmd:  ls  
cli
cli.cpp
inputs.md

## ./cli notACommand, ls, touch temp.txt, ls

AlecResha - cli - 11/18/2021  
Legal commands: cd exec exit gcc ls man more mv rm pwd sh touch which $PATH  
6 strings passed to argv  
Error: notACommand, is not a legal command  
cmd:  ls  
cli
cli.cpp
inputs.md  
cmd:  touch temp.txt  
cmd:  ls  
cli
cli.cpp
inputs.md
temp.txt

## ./cli ls, mv temp.txt temp2.txt, ls, rm temp2.txt, ls

AlecResha - cli - 11/18/2021  
Legal commands: cd exec exit gcc ls man more mv rm pwd sh touch which $PATH  
9 strings passed to argv  
cmd:  ls  
cli
cli.cpp
inputs.md
temp.txt  
cmd:  mv temp.txt temp2.txt  
cmd:  ls  
cli
cli.cpp
inputs.md
temp2.txt  
cmd:  rm temp2.txt  
cmd:  ls  
cli
cli.cpp
inputs.md

## echo "echo \"\n\nStart sh file \n\n\"; ./cli pwd, ls; echo \"\n\nEnd of sh output\n\n\"" >> temp.sh; ./cli more temp.sh, sh ./temp.sh, ls, pwd, rm temp.sh, ls

AlecResha - cli - 11/18/2021  
Legal commands: cd exec exit gcc ls man more mv rm pwd sh touch which $PATH  
10 strings passed to argv  
cmd:  more temp.sh  
echo "

Start sh file 

"; ./cli pwd, ls; echo "

End of sh output

"
cmd:  sh ./temp.sh


Start sh file 


AlecResha - cli - 11/18/2021  
Legal commands: cd exec exit gcc ls man more mv rm pwd sh touch which $PATH  
3 strings passed to argv  
cmd:  pwd  
/home/alec/notesRepo/fall2021/CSc139/hw05  
cmd:  ls  
cli
cli.cpp
inputs.md
temp.sh


End of sh output


cmd:  ls  
cli
cli.cpp
inputs.md
temp.sh  
cmd:  pwd  
/home/alec/notesRepo/fall2021/CSc139/hw05  
cmd:  rm temp.sh  
cmd:  ls  
cli
cli.cpp
inputs.md
