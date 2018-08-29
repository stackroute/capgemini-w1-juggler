# base image
FROM node:8.11.3 as builder
COPY . /juggler
WORKDIR /juggler
RUN npm install

#build angular application in prod mode
RUN $(npm bin)/ng build --prod

# start app on nginx web server
FROM nginx:stable-alpine
COPY --from=builder /juggler/dist/* /usr/share/nginx/html/
EXPOSE 80