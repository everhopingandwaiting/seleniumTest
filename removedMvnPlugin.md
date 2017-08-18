##  unnecessary maven plugin

   <!--   <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                            <mainClass>m</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
            &lt;!&ndash; 拷贝依赖的jar包到lib目录 &ndash;&gt;
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <executions>
                    <execution>
                        <id>copy</id>
                        <phase>package</phase>
                        <goals>
                            <goal>copy-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>
                                ${project.build.directory}/lib
                            </outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>-->


            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>2.5.5</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>m</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

            <plugin>
                <artifactId>maven-antrun-plugin</artifactId>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>run</goal>
                        </goals>
                        <configuration>
                            <tasks>

                                <copy todir="${project.build.directory}/driver" overwrite="true">
                                    <fileset dir="${pom.basedir}/driver"/>
                                </copy>


                            </tasks>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <!--     <plugin>
                     <groupId>org.apache.maven.plugins</groupId>
                     <artifactId>maven-dependency-plugin</artifactId>
                     <executions>
                         <execution>
                             <id>copy</id>
                             <phase>install</phase>
                             <goals>
                                 <goal>copy-dependencies</goal>
                             </goals>
                             <configuration>
                                 <outputDirectory>
                                     ${project.build.directory}/${pom.name}/WEB-INF/lib
                                 </outputDirectory>
                             </configuration>
                         </execution>
                     </executions>
                 </plugin>
     -->

            <!-- 解决资源文件的编码问题 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
                <version>2.3</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <!-- 打包source文件为jar文件 -->
            <plugin>
                <artifactId>maven-source-plugin</artifactId>
                <version>2.1</version>
                <configuration>
                    <attach>true</attach>
                    <!--<encoding>UTF-8</encoding>-->
                </configuration>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>


