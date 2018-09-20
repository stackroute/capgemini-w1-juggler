# base image
# FROM node:8.11.3 as builder
# COPY . /juggler
# WORKDIR /juggler
# RUN npm install

# #build angular application in prod mode
# RUN $(npm bin)/ng build --prod

# # start app on nginx web server
# FROM nginx:stable-alpine
# COPY --from=builder /juggler/dist/* /usr/share/nginx/html/
# EXPOSE 8081

# base image
# FROM node:8.11.3 
# RUN mkdir -p /usr/src/app

# WORKDIR /usr/src/app
# COPY package.json /usr/src/app
# RUN npm cache verify
# RUN npm install
# COPY . /usr/src/app
# # start app
# ENTRYPOINT ["npm","start"]

# EXPOSE 4200

# base image
FROM node:8.11.3 
COPY /dist/Juggler-Front-End /usr/src/app
WORKDIR /usr/src/app
RUN npm install http-server -g

# start app
ENTRYPOINT ["http-server","-o"]
EXPOSE 4200

